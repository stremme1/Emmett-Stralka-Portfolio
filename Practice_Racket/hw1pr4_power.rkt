#lang racket
(require rackunit)
(provide power fast-power)

(define (power b p)
  ;; Base case: p is 0, return 1
  (if (= p 0) 1
      ;; Recursive case: Multiply b by (power b (p-1))
      (* b (power b (- p 1)))))

(define (fast-power b p)
  ;; Base case: p is 0, return 1
  (if (= p 0) 1
      ;; If p is odd, multiply b by (fast-power b (p-1))
      (if (odd? p) (* b (fast-power b (- p 1)))
          ;; If p is even, calculate half-power and square it
          (let ((half-power (fast-power b (/ p 2))))
            (* half-power half-power)))))
