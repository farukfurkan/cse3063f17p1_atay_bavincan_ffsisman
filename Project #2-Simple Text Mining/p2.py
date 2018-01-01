import os

from os import path
from wordcloud import WordCloud
import matplotlib.pyplot as plt
from nltk import word_tokenize
from nltk.corpus import stopwords
import string
from sklearn.feature_extraction.text import CountVectorizer,TfidfVectorizer
import numpy as np
import operator
from pandas import DataFrame
import csv
import mammoth
import PyPDF2
import re



def readFilesInDirAndCleanWordList(stop):
    dire = path.dirname(__file__)
    p = os.path.join(dire, 'text files/')

    mergedLines=[]

    for i in os.listdir(os.path.join(dire, 'text files')):
        if(i.endswith('.txt')):
             file= open(path.join(p, i),"r")
             lines = file.readlines()
             lines=re.sub("[^\w]"," ",lines[0]).split()
             mergedLines =mergedLines + lines 
        elif(i.endswith('.docx')):
            with open(path.join(p, i), "rb") as docx_file:
                result = mammoth.extract_raw_text(docx_file)
                text = result.value 
                lines = [text]
                lines=re.sub("[^\w]"," ",lines[0]).split()
                mergedLines = mergedLines + lines
        elif(i.endswith('.pdf')):
            pdfFileObj = open(path.join(p, i), 'rb')
            pdfReader = PyPDF2.PdfFileReader(pdfFileObj)
            for i in range (0,pdfReader.numPages):
                pageObj = pdfReader.getPage(i)
                text = pageObj.extractText();
                lines = [text]
                lines=re.sub("[^\w]"," ",lines[0]).split()
                mergedLines = mergedLines + lines

    mergedLines= [''.join(c for c in s if c not in string.punctuation) for s in mergedLines]
    mergedLines= [i.lower() for i in mergedLines ]
    mergedLines = [i for i in mergedLines if i not in stop]
    return mergedLines


def makeWordCloud(filename):
    reader_list = []
    with open(filename, 'r') as f:
        reader = csv.reader(f)
        reader_list = '\t'.join([i[0] for i in reader])
    
    wordcloud = WordCloud().generate(reader_list)
    plt.imshow(wordcloud, interpolation='bilinear')
    plt.axis("off")
    plt.show()

def makeDataframeAndWriteToCsv(freq,vocab,columnName,filename):   
    df=DataFrame(freq,vocab)
    df.columns=[columnName]
    df=df.sort_values(by=columnName,ascending=0)
    df=df.nlargest(50,columnName)

    df.to_csv(filename)




#set stopwords from nltk and add some other words that used in scientific papers usually
stop = set(stopwords.words('english'))
stop.add('abstract')
stop.add('introduction')
stop.add('conclusions')
stop.add('related')
stop.add('work')
stop.add('author')
stop.add('university')

#read files in directory and hold words that cleaned from stopwords and punctiations
mergedLines=readFilesInDirAndCleanWordList(stop)

#get term frequency values            
vectorizer = CountVectorizer()
X = vectorizer.fit_transform(mergedLines)
freq = np.ravel(X.sum(axis=0))    
vocab = [v[0] for v in sorted(vectorizer.vocabulary_.items(), key=operator.itemgetter(1))]

#duties that write in project document
makeDataframeAndWriteToCsv(freq,vocab,'tf values','tf_list.csv')
makeWordCloud('tf_list.csv')


#get tfidf values
vectorizer = TfidfVectorizer()
X = vectorizer.fit_transform(mergedLines)
idf =vectorizer.idf_

#duties that write in project document
makeDataframeAndWriteToCsv(idf,vectorizer.get_feature_names(),'tf-idf values','tfıdf_list.csv')
makeWordCloud('tfıdf_list.csv')





