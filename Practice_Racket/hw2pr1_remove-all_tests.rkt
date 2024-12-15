#lang racket

(require rackunit)
(require "hw2pr1_remove-all.rkt")


; student tests
(check-equal? (remove-all "a" '("h" "r" "v" "e" "y" "Mudd")) 
              '("h" "r" "v" "e" "y" "Mudd"))
(check-equal? (remove-all "Mudd" '( ("h" "a" "r" "v" "e" "y") "Mudd")) 
              '(("h" "a" "r" "v" "e" "y")))
(check-equal? (remove-all 1 '(1 2 3 1 4 1))  
              '(2 3 4))


; provided tests
(check-equal? (remove-all "i" '("a" "l" "i" "i" "i" "e" "n")) 
              '("a" "l" "e" "n"))
(check-equal? (remove-all "i" '( ("a" "l" "i") "i" "i" "e" "n")) 
              '(("a" "l" "i") "e" "n"))
(check-equal? (remove-all 0 '(1 0 1 0 1 0))  
              '(1 1 1))

