import sys
from collections import OrderedDict
class MapReduce:
    def __init__(self):
        self.intermediate = OrderedDict()
        self.result = []


    def emitIntermediate(self, key, value):
        self.intermediate.setdefault(key, [])
        self.intermediate[key].append(value)

    def emit(self, value):
        self.result.append(value)

    def execute(self, data, mapper, reducer):
        for record in data:
            mapper(record)

        for key in self.intermediate:
            reducer(key, self.intermediate[key])

        self.result.sort()
        for item in self.result:
            print item

mapReducer = MapReduce()

def mapper(record):
    #Start writing the Map code here
    words = record.rstrip().split(',')
    if words[0]=='Department':
        mapReducer.emitIntermediate(words[1],('D',words[2]))
    elif words[0]=='Employee':
        mapReducer.emitIntermediate(words[2],('P',words[1]))

def reducer(key, list_of_values):
    #Start writing the Reduce code here
    list_of_values.sort()
    name = list_of_values[-1][-1]
    for d in list_of_values:
        if d[0]!='P':
            mapReducer.emit((key,name, d[-1]))

if __name__ == '__main__':
    inputData = []
    for line in sys.stdin:
        inputData.append(line)
    mapReducer.execute(inputData, mapper, reducer)
