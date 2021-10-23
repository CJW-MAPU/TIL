from flask import Flask, render_template
from service.model import run_model

app = Flask(__name__)


@app.route('/')
def hello_world(name = None):
    a = run_model()

    return_value = render_template('main.html',
                                   data = a,
                                   test = 20
    )

    return return_value


if __name__ == '__main__':
    app.run()
