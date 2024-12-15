#lang racket
(require "hw3pr2_indivisible.rkt")
(require rackunit)

;; Student cases

(check-equal? (indivisible 2 '(1 2 3 4 5 6)) '(1 3 5))
(check-equal? (indivisible 3 '(1 2 3 4 5 6 7 8 9 )) '(1 2 4 5 7 8)) ; no indivisible numbers
(check-equal? (indivisible 3 '(1 3 6 9 )) '(1)) ; all numbers indivisible

;; Provided Test cases

(check-equal? (indivisible 3 '(2 3 4 5 6 7 8 9 10 )) '(2 4 5 7 8 10))

