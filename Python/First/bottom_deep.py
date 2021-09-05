import numpy as np


def main():
    x = np.array([0, 1])
    w = np.array([-0.5, -0.5])
    b = 0.7
    print(NAND(x, w, b))


def AND(x: np.array, w: np.array, b: float) -> int:
    tmp = np.sum(w * x) + b
    if tmp <= 0:
        return 0
    else:
        return 1


def NAND(x: np.array, w: np.array, b: float) -> int:
    tmp = np.sum(w * x ) + b
    if tmp <= 0:
        return 0
    else:
        return 1


if __name__ == '__main__':
    main()
