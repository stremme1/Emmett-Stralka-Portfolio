#lang racket


(require rackunit)
(require "hw2pr2_prefix_sublist.rkt")


; student tests

; Additional Student Tests for sublist?


(check-true (sublist? '(H A) '(H A R V E Y))) ; Should be T
(check-true (sublist? '(E Y) '(H A R V E Y))) ; Should be T
(check-true (sublist? '(H A R V) '(H A R V E Y))) ; Should be T

(check-true (prefix? '(H A) '(H A R V E Y))) ; Should be T
(check-false (prefix? '(E Y) '(H A R V E Y))) ; Should be F
(check-true (prefix? '(H A R V) '(H A R V E Y))) ; Should be T


; provided tests

(check-true  (sublist? '()    '(s p a m)))
(check-true  (sublist? '(s p) '(s p a m)))
(check-false (sublist? '(s m) '(s p a m)))
(check-true  (sublist? '(p a) '(s p a m)))


(check-true  (prefix? '()    '(s p a m)))
(check-true  (prefix? '(s p) '(s p a m)))
(check-false (prefix? '(s m) '(s p a m)))
(check-false (prefix? '(p a) '(s p a m)))

