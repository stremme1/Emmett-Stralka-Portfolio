#lang racket
(require rackunit)

(require "hw2pr3_enumerate.rkt")

; Student Tests
(check-equal? (enumerate '(H A R V)) 
 '((0 H) (1 A) (2 R) (3 V)))
(check-equal? (enumerate '(H A R V Y M E D D)) 
 '((0 H) (1 A) (2 R) (3 V) (4 Y) (5 M) (6 E) (7 D) (8 D)))


; Given Tests

(check-equal? (enumerate '(jan feb mar apr)) 
 '((0 jan) (1 feb) (2 mar) (3 apr)))

(check-equal? (enumerate '(0 I II III IV V VI)) 
                         '((0 0) (1 I) (2 II) (3 III) (4 IV) (5 V) (6 VI)))

(check-equal? (enumerate '())  '())