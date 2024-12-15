#lang racket
(provide indivisible)

;; indivisible: Returns a list that are not divisible by the divisor.
;; input:
;;   e: A positive integer divisor
;;   L: A list of positive integers
;; output:
;;   A list containing all of the elements of L that are not divisible by e.
(define (indivisible e L)
  (filter (lambda (x) (not (= 0 (modulo x e)))) L))
