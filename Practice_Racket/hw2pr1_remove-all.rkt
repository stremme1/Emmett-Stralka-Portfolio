#lang racket

(provide remove-all)

;; remove-all: removes all top-level instances of element from list
;;  inputs: element to remove, elem
;;          list to remove from, L
;;  output: list identical to L with all top-level instances of elem removed
(define (remove-all elem L)
  (cond
    ((null? L) '())          ; If the list is empty, return an empty list.
    ((equal? (car L) elem)   ; If the first element of the list is equal to elem,
     (remove-all elem (cdr L))) ; skip it and recursively process the rest of the list.
    (else                    ; If the first element is not equal to elem,
     (cons (car L)           ; include it in the result and recursively process the rest.
           (remove-all elem (cdr L))))))

  
       ;; does not change list until implemented!

