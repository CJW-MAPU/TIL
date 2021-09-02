from keras.models import Model, Sequential
from keras.layers import Dense, Input
from keras.layers.advanced_activations import LeakyReLU
from keras.optimizers import adam_v2
from keras.datasets import mnist
from tqdm import tqdm
from tensorflow import device
import numpy as np
import matplotlib.pyplot as plt


def main():
    (xTrain, yTrain), (xTest, yTest) = mnist.load_data()
    xTest = (xTest.astype(np.float32) - 127.5) / 127.5
    mnistData = xTest.reshape(10000, 784)

    g = createGenerator()
    g.summary()

    d = createDiscriminator()
    d.summary()

    gan = createGan(d, g)
    gan.summary()

    batchSize = 128
    epochs = 5000

    for e in tqdm(range(epochs)):
        noise = np.random.normal(0, 1, [batchSize, 100])
        generatedImages = g.predict(noise)
        imageBatch = mnistData[np.random.randint(low = 0, high = mnistData.shape[0], size = batchSize)]

        X = np.concatenate([imageBatch, generatedImages])
        yDis = np.zeros(2 * batchSize)
        yDis[:batchSize] = 1
        d.trainable = True
        d.train_on_batch(X, yDis)

        noise = np.random.normal(0, 1, [batchSize, 100])
        yGen = np.ones(batchSize)
        gan.train_on_batch(noise, yGen)

        d.trainable = False
        gan.train_on_batch(noise, yGen)

        if e == 0 or e % 1000 == 0:
            plotGeneratedImages(g)


def createGenerator():
    generator = Sequential()
    generator.add(Dense(units = 256, input_dim = 100))
    generator.add(LeakyReLU(0.2))
    generator.add(Dense(units = 512))
    generator.add(LeakyReLU(0.2))
    generator.add(Dense(units = 784, activation = 'tanh'))

    return generator


def createDiscriminator():
    discriminator = Sequential()
    discriminator.add(Dense(units = 512, input_dim = 784))
    discriminator.add(LeakyReLU(2.0))
    discriminator.add(Dense(units = 256))
    discriminator.add(LeakyReLU(2.0))
    discriminator.add(Dense(units = 1, activation = 'sigmoid'))

    discriminator.compile(loss = 'binary_crossentropy', optimizer = adam_v2.Adam(learning_rate = 0.0002, beta_1 = 0.5))

    return discriminator


def createGan(discriminator, generator):
    discriminator.trainable = False
    ganInput = Input(shape = (100, ))

    x = generator(ganInput)

    ganOutput = discriminator(x)
    gan = Model(inputs = ganInput, outputs = ganOutput)
    gan.compile(loss = 'binary_crossentropy', optimizer = 'adam')

    return gan


def plotGeneratedImages(generator):
    noise = np.random.normal(loc = 0, scale = 1, size = [100, 100])
    generatedImages = generator.predict(noise)
    generatedImages = generatedImages.reshape(100, 28, 28)

    plt.figure(figsize = (10, 10))

    for i in range(generatedImages.shape[0]):
        plt.subplot(10, 10, i + 1)
        plt.imshow(generatedImages[i], interpolation = 'nearest')
        plt.axis('off')

    plt.tight_layout()
    plt.show()


if __name__ == '__main__':
    with device("/CPU:0"):
        main()
