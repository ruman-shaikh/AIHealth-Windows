import sys
import numpy as np
import pickle

inStr = sys.argv
inStr.pop(0)
JstStr = inStr[0]

input_list = JstStr.split()
temp_list = []

for i in input_list:
	temp_list.append(float(i))

np_input = np.asarray(temp_list)
np_input = np.reshape(np_input, (1, -1))

filename = 'D:\\Projects\\Ongoing_Projects\\AIHeath\\pythonlab\\RandomForestModel.sav'
model = pickle.load(open(filename, 'rb'))

x = model.predict(np_input)[0]
print(x)