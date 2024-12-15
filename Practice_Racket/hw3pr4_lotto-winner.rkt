#lang racket

(provide matches)
(provide lotto-winner)


;; matches: finds the number of matches between ticket and winning numbers
;;   inputs: tickets - lotto ticket, list of numbers
;;             expected format:  '(name # # ... #)
;;           winning-numbers - winning numbers, list of numbers
;;             expected format:  '(# # .. #)
;;   output: the number elements that match between tickets and winning-numbers
(define (matches ticket winning-numbers)
  (length 
   (filter (lambda (potential-match) 
             (member potential-match winning-numbers))
           ticket)))


;; lotto-winner: finds the name and number of the winning ticket
;;  inputs: list-of-tickets - list of lotto tickets, list of lists of numbers
;;       expected format: '(name) ... (#ofmatches)) 
;;      winning-numbers - winning numbers, list of numbers
;;       expected format: '(name #ofmatches)
;;  output: the name and number of matching tickets from the ticket
(define (lotto-winner list-of-tickets winning-numbers)
                        (let* ([winlist (map(lambda(elm)(list(first elm) (matches elm winning-numbers))) list-of-tickets)]
[topp(sort winlist(lambda(fir sec) (> (last fir) (last sec))))])
(if (equal? (last topp) 0) '()
    (first topp))))

  




     

