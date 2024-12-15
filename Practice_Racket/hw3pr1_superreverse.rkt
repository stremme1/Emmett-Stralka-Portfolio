#lang racket

(provide superreverse)


;; superreverse: Reverses a list of lists
;;
;; input: A list of lists
;; output: A list containing the reversed elements of each list in the input list
;;
;; Use higher-order functions (no recursion!)
(define (superreverse L)
  (if (empty? L)
      '()
      (map reverse L)))


