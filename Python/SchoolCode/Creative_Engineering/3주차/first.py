import turtle

t = turtle.Turtle()
t.shape('turtle')

angle = 120

for i in range(0, 3):
    if i == 1:
        angle = -angle
    t.right(angle)
    t.forward(100)
