package secondo;
import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
 

public class Captcha {
	
	private String[] domande = {"Dov'è il Big Ben?", "Qual è la capitale della Birmania?", "Qual è l'integrale di e^x?"};
	private String[] pwds = {"4653a0272adfb98c8bb74f2e634c8d0d1d819fff", "7be9748982698fdf7e39def428f9735c20622ccd", "1624dce91de495347430ec2518baf6c6a5328d2e"};
	private int scelta = 0;
	private Random casuale = new Random();
	private String domanda = null;
	private String pwd = null; 
	
	protected String proponi_domanda()
	{
		scelta = casuale.nextInt(2);
		this.domanda = domande[scelta];
		this.pwd = pwds[scelta];
		return domande[scelta];
	}
	
	private boolean controllo(String challenge)
	{
		try {
			if(challenge.equals(sha1(pwds[scelta])))
			{
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		}
		return false;
		
	}
	
	
	private String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
	

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
