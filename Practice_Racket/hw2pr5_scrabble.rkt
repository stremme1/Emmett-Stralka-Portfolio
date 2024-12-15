#lang racket



(provide subbag? scrabble-tile-bag score-letter score-word scoreword)

;; subbag?: Checks if S is a subbag of B
;;   inputs: S and B lists
;;           S sublist 
;;           B the list checkk
;;   output: #t if S is a subbag of B, F otherwise
(define (subbag? S B)
  (cond
    [(null? S) #t]                      ; Base case: S is empty, it's a subbag
    [(null? B) #f]                      ; Base case: B is empty, S is not a subbag
    [(not (member (first S) B)) #f]     ; If the first element of S is not in B, it's not a subbag
    [else (subbag? (rest S) (remove (first S) B))])) ; Recursively check the rest of S and B
                                

(define scrabble-tile-bag
  '((#\a 1 9) (#\b 3 2) (#\c 3 2) (#\d 2 4) (#\e 1 12)
   (#\f 4 2) (#\g 2 3) (#\h 4 2) (#\i 1 9) (#\j 8 1)
   (#\k 5 1) (#\l 1 4) (#\m 3 2) (#\n 1 6) (#\o 1 8)
   (#\p 3 2) (#\q 10 1)(#\r 1 6) (#\s 1 4) (#\t 1 6)
   (#\u 1 4) (#\v 4 2) (#\w 4 2) (#\x 8 1) (#\y 4 2)
   (#\z 10 1) (#\_ 0 2)) ) 

;; scrabble-letter: Helper function for calculating Scrabble score
;;   inputs: word
;;           word - the word to calculate the score for
;;   output: the Scrabble score for the given word
(define (score-letter word)
  (second (assoc word scrabble-tile-bag))); recurse and calculate the score for the rest

;; scrabble-word: Helper function for calculating word score
;;   inputs: word
;;       
;;   output: the Scrabble score for the given word

(define (scoreword word)
  (if (empty? word)
      0
      (+ (score-letter  (first word)) (scoreword (rest word)))))

;; scrabble-score: Calculates the Scrabble score for a word
;;   inputs: word
;;           word givenr
;;   output: the Scrabble score for the given word
(define (score-word word)
  (scoreword (string->list word)))

(define (best-word rack WL)
  ; Helper function to calculate the score of a word
    (if (empty? word)
        0
        (+ (score-letter (car word)) (scoreword (cdr word)))))


; this is as far as I got
  







  

