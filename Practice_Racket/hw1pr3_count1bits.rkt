#lang racket

(require rackunit)
(provide count1bits)

; if it's a 1, shift right and count 1; if not, just shift right
(define (count1bits N)
  (cond
    [(= N 0) 0]                        ; Base case
    [(odd? N) (+ 1 (count1bits (quotient N 2)))] ; + 1, shift right
    [else (count1bits (quotient N 2))])) ; shift right

