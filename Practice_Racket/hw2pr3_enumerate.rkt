#lang racket

(provide enumerate ecount)

;; Ecount: returns the number of times it's iterated
;;  inputs: L Index
;;  output: Just a number starting at 0 1 2 3  
(define (ecount L index)
  (cond
    [(null? L) '()]                         ; Check empty list
    [else (cons (list index (first L))      ; Add index and element
                (ecount (rest L) (+ index 1)))])) ; Recurse with incremented index

;; enumerate: returns a list Similar to L; however, it gives a value starting at 0 to the listed values
;;  inputs: L
;;  output: New list L with (0 0) (1 1) ...
(define (enumerate L)
  (ecount L 0))  ; Recurse with index starting at 0


