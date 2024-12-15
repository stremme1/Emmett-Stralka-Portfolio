#lang racket

(require rackunit)
(require "hw1pr3_count1bits.rkt")


; student tests
(check-equal? (count1bits 12) 2) ; Should be 2
(check-equal? (count1bits 88) 3) ; Should be 3
(check-equal? (count1bits 137) 3) ; Should be 3


; provided tests
(check-equal? (count1bits 6) 2)
(check-equal? (count1bits 7) 3)
(check-equal? (count1bits 42) 3)