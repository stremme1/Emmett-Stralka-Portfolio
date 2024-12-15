#lang racket
(require rackunit)
(require "hw2pr4_superduper.rkt")

; Student Tests

(check-equal? (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
                            '( (3 2 1) (9 (7 8) 6 5 4) ) )

(check-equal? (superreverse '( (0 1 2) (3 4 5) (#\j #\n #\n #\m) (#\` #\l) ))
                            '( (2 1 0) (5 4 3) (#\m #\n #\n #\j) (#\l #\`) ))

(check-equal? (duperreverse '( (0 1 2) (3 4 5) 41 ("j" "n" "n" "m") ("`" "l") ))
                            '( ("l" "`") ("m" "n" "n" "j") 41 (5 4 3) (2 1 0) ))

(check-equal? (duperreverse '( (0 1 2) (3 4 5 (6 7) 8) ))
                            '( (8 (7 6) 5 4 3) (2 1 0) ))




; Given Tests

(check-equal? (superreverse '( (1 2 3) (4 5 6 (7 8) 9 ) ))
                            '( (3 2 1) (9 (7 8) 6 5 4) ) )

(check-equal? (superreverse '( (1 2 3) (4 5 6) (#\k #\o #\o #\l) (#\a #\m) ))
                            '( (3 2 1) (6 5 4) (#\l #\o #\o #\k) (#\m #\a) ) )

(check-equal? (duperreverse '( (1 2 3) (4 5 6) 42 ("k" "o" "o" "l") ("a" "m") ))
                            '( ("m" "a") ("l" "o" "o" "k") 42 (6 5 4) (3 2 1) ))

(check-equal? (duperreverse '( (1 2 3) (4 5 6 (7 8) 9) ))
                            '( (9 (8 7) 6 5 4) (3 2 1) ))



