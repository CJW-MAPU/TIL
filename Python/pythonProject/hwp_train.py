from pandas import read_csv
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import f1_score, accuracy_score, confusion_matrix
from sklearn.naive_bayes import BernoulliNB, GaussianNB, MultinomialNB
from sklearn.pipeline import make_pipeline
from sklearn.preprocessing import StandardScaler, MinMaxScaler
from sklearn.model_selection import GridSearchCV


dataset = read_csv('dataset/(after) hwp_train.csv', encoding = 'cp949')
dataset = dataset.drop(['Unnamed: 0'], axis = 'columns')
print(list(dataset.columns))
X = dataset.iloc[:, :-1]
y = dataset.iloc[:, -1]

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=1)

param_alpha = [0.0001, 0.001, 0.01, 0.1, 1.0, 10.0, 100.0, 1000.0]
param_grid = [
    {'multinomialnb__alpha': param_alpha}
]

pipeline = make_pipeline(
    MinMaxScaler(),
    MultinomialNB()
)

gs = GridSearchCV(estimator = pipeline,
                  param_grid = param_grid,
                  scoring = 'accuracy',
                  cv = 5, refit = True,
                  n_jobs = -1, verbose = 10)


gs.fit(X_train, y_train)

print(gs.best_score_)
print(gs.best_params_)

clf = gs.best_estimator_

predict = clf.predict(X_test)

print(confusion_matrix(y_test, predict))
print(accuracy_score(y_test, predict))
