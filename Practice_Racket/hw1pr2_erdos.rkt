#lang racket
(require rackunit)
;; Two functions will be treated as publicly accessible
;;   (so that we can test them)
(provide erdos erdos-count)


;; erdos: the "erdos" function
;;   input: a positive integer, N
;;   output: 3N+1, if N is odd
;;           N/2, if N is even
(define (erdos N)
  (if (odd? N)
      (+(* 3 N) 1)
  (/ N 2)))

  
;;           N/2, if N is even
  ; NOTE: STOP - Do not write code here until you have written tests! 
  ; NOTE: Delete this and the note above when you start writing code.


;; Note: Delete this note and write a comment for erdos-count
;; Note: Delete this note and write a comment for erdos-count

      
  ; NOTE: STOP - Do not write code here until you have written tests! 
  ; NOTE: Delete this and the note above when you start writing code.

(define (erdos-count N)
  (cond
    [(= N 1) 0]
    [else
     (+ 1 (erdos-count (erdos N)))]))




