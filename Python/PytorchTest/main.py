from typing import Optional
from torch import nn
from torch.utils.data import DataLoader
from torchvision import datasets
from torchvision.transforms import ToTensor
from torch.optim.optimizer import Optimizer

import torch


device = "cuda" if torch.cuda.is_available() else "cpu"
print(f'using {device} device')


class NeuralNetwork(nn.Module):
    def __init__(self):
        super(NeuralNetwork, self).__init__()
        self.flatten = nn.Flatten()
        self.linear_relu_stack = nn.Sequential(
            nn.Linear(28 * 28, 512),
            nn.ReLU(),
            nn.Linear(512, 512),
            nn.ReLU(),
            nn.Linear(512, 10)
        )

    def forward(self, x):
        x = self.flatten(x)
        logits = self.linear_relu_stack(x)
        return logits


class _RequiredParameter(object):
    """Singleton class representing a required parameter for an Optimizer."""
    def __repr__(self):
        return "<required parameter>"


required = _RequiredParameter()


class GDM(Optimizer):
    def __init__(self, params, lr = required, momentum = 0, dampening = 0,
                 weight_decay = 0, nesterov = False, *, maximize = False, foreach: Optional[bool] = None):
        if lr is not required and lr < 0.0:
            raise ValueError("Invalid learning rate: {}".format(lr))
        if momentum < 0.0:
            raise ValueError("Invalid momentum value: {}".format(momentum))
        if weight_decay < 0.0:
            raise ValueError("Invalid weight_decay value: {}".format(weight_decay))

        defaults = dict(lr = lr, momentum = momentum, dampening = dampening,
                        weight_decay = weight_decay, nesterov = nesterov,
                        maximize = maximize, foreach = foreach)
        if nesterov and (momentum <= 0 or dampening != 0):
            raise ValueError("Nesterov momentum requires a momentum and zero dampening")
        super(GDM, self).__init__(params, defaults)

    @torch.no_grad()
    def step(self, closure = None):
        pass


def train(dataloader, model, loss_fn, optimizer):
    size = len(dataloader.dataset)
    for batch, (X, y) in enumerate(dataloader):
        X, y = X.to(device), y.to(device)

        pred = model(X)
        loss = loss_fn(pred, y)

        optimizer.zero_grad()
        loss.backward()
        optimizer.step()

        if batch % 100 == 0:
            loss, current = loss.item(), batch * len(X)
            print(f'loss: {loss:>7f} [{current:>5d}/{size:>5d}]')


def test(dataloader, model, loss_fn):
    size = len(dataloader.dataset)
    num_batches = len(dataloader)
    model.eval()
    test_loss, correct = 0, 0
    with torch.no_grad():
        for X, y in dataloader:
            X, y = X.to(device), y.to(device)
            pred = model(X)
            test_loss += loss_fn(pred, y).item()
            correct += (pred.argmax(1) == y).type(torch.float).sum().item()
    test_loss /= num_batches
    correct /= size
    print(f'Test Error : \n Accuracy: {(100 * correct):>0.1f}%, Avg loss: {test_loss:>8f} \n')


if __name__ == '__main__':
    training_data = datasets.FashionMNIST(
        root = 'data',
        train = True,
        download = True,
        transform = ToTensor()
    )

    test_data = datasets.FashionMNIST(
        root = 'data',
        train = True,
        download = True,
        transform = ToTensor()
    )

    batch_size = 64

    train_dataloader = DataLoader(training_data, batch_size = batch_size)
    test_dataloader = DataLoader(test_data, batch_size = batch_size)

    for X, y in test_dataloader:
        print(f"Shape of X [N, C, H, W]: {X.shape}")
        print(f"Shape of y: {y.shape} {y.dtype}")
        break

    model = NeuralNetwork().to(device)
    print(model)

    loss_fn = nn.CrossEntropyLoss()
    optimizer = torch.optim.SGD(model.parameters(), lr = 1e-3, momentum = 0.9)
    # optim = GDM(model.parameters(), lr = 1e-3)

    epochs = 5
    for t in range(epochs):
        print(f"Epoch {t + 1}\n-------------------------------")
        train(train_dataloader, model, loss_fn, optimizer)
        test(test_dataloader, model, loss_fn)
    print("Done!")



