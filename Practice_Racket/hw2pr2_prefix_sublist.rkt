#lang racket

(provide prefix?)
(provide sublist?)


;; prefix: returns the longest prefix
;;  inputs: P and L
;;          list to remove from, L
;;  output: the lonest prefix or F if L is empty 
(define (prefix? P L)
  (cond
    ((null? P) #t)         ; Check Empty '() tech is a prefix
    ((null? L) #f)         ; Check Empty
    ((equal? (first P) (first L)) ; Check firsts in each P L
     (prefix? (rest P) (rest L))) ; returns the firsts then recurse the rest
    (else #f)))

;; Sublistl: Checks if T or F of prefix
;;  inputs: S and L
;;          
;;  output: a T or F conditional 
(define (sublist? S L)
  (cond
    ((null? S) #t)         ; Check empty '() tech is a sublist
    ((null? L) #f)         ; Check Empty
    ((prefix? S L) #t)     ; Returns trun if prefix works 
    (else (sublist? S (rest L))))); All case catch False


