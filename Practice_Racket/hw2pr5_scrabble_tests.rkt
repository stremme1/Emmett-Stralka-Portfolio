#lang racket

(require rackunit)

(require "hw2pr5_scrabble.rkt")

; student tests

(check-true (subbag? '() '(s p a m s)))
(check-false (subbag? '(a m a) '(s p a m s)))

(check-equal? (assoc #\a scrabble-tile-bag) '(#\a 1 9))
(check-equal? (assoc #\q scrabble-tile-bag) '(#\q 10 1))

(check-equal? (score-letter #\a) 1)
(check-equal? (score-letter #\z) 10)

(check-equal? (score-letter #\a) 1)
(check-equal? (score-letter #\z) 10)

(check-equal? (score-word "zzz") 30)
(check-equal? (score-word "fortytwo") 17)

(check-equal? (best-word "academy" '("ace" "ade" "cad" "cay" "day")) '("cay" 8))
(check-equal? (second (best-word "bcademy" '("ace" "ade" "cad" "cay" "bay"))) 8)





; provided tests

(check-equal? (score-word "zzz") 30)
(check-equal? (score-word "fortytwo") 20)
(check-equal? (score-word "twelve") 12)


