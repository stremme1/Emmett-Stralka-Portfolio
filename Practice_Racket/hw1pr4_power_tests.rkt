#lang racket
(require rackunit)

(require "hw1pr4_power.rkt")
(provide power)
(provide fast-power) 

; student test cases

(check-equal? (power 2 3) 8) ; should be 8

; student tests
(check-equal? (power 2 0) 1)    ;  should be 1
(check-equal? (power 3 4) 81)   ;  should be 81

; student tests 
(check-equal? (fast-power 2 0) 1)    ; should be 1
(check-equal? (fast-power 3 4) 81)   ; should be 81

(check-equal? (power 4 1) 4)

(check-equal? (power 2 10) 1024)
(check-equal? (power 42 10) 17080198121677824)

(check-equal? (fast-power 2 10) 1024)
(check-equal? (fast-power 42 10) 17080198121677824)
