package secondo;

public class Captcha {
	
	
	
	

}







/*
#! /usr/bin/env python
# encoding: utf-8

import sys
import time
import random
import hashlib

def ask_question():
  questions = [
    ('What animal has a trunk?', ('1c6f116ce35bbe8b5c5b3a26cfa9e63c4b7cff24', '0ae9e4deba26021986ffd99636da6601f6393631')),
    ('How many continents are there?', ('902ba3cda1883801594b6e1b452790cc53948fda')),
    ('Where is Big Ben?', ('707fe00aa123eb0be5010f1d3065c2b6d7934ca4', '4c57f0c88d9844630327623633ce269cf826ab99'))
  ]
  random.seed(time.time())
  question = questions[random.randint(0, len(questions) - 1)]
  answers = question[1]
  question = question[0]
  sys.stdout.write(question + '\n')
  try:
    user = input('Answer: ')
  except NameError:
    user = raw_input('Answer: ')
  sha1 = hashlib.new('sha1')
  sha1.update(user.encode())
  if sha1.hexdigest() not in answers:
    sys.stderr.write('Not a correct answer\n')
    sys.exit(1)

ask_question()
*/
