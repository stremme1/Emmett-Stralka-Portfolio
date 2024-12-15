#lang racket
(provide superreverse  duperreverse)

(define (reverse L)
  (if (null? L)
      '() ; Base case: if L is empty, return an empty list
      (append (reverse (rest L)) (list (first L)))))

;; Superreverse: removes all top-level instances of element from list
;;  inputs: L
;;  output: reverses L and Lists in L
(define (superreverse L)
  (if (null? L)
      '()
      (cons (reverse (first L)) (superreverse (rest L)))))  ; cons first list and then recurse on the rest of L


;; duperreverse: removes all top-level instances of element from list
;;  inputs: L
;;  output: reverses L and Lists of lists in L
(define (duperreverse L)
  (cond
    [(null? L) '()] ; Base case: empty list
    [(list? (first L)) ; Check if the first element is a list
     (append (duperreverse (rest L)) (list (duperreverse (first L))))] ; Reverse the first element deeply and process the rest
    [else ; If the first element is not a list
     (append (duperreverse (rest L)) (list (first L)))])) ; Process the rest of the list





