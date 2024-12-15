#lang racket

(require "BST.rkt")
(provide height)
(provide find-min)
(provide in-order)
(provide delete)


;; height: returns the height of a BST
;;   input: a BST
;;   output: the number of edges on the longest path from the root to a leaf
(define (height tree)
  (cond
    ((emptyTree? tree) -1) ; Height of an empty tree is -1
    ((leaf? tree) 0)       ; Height of a leaf node is 0
    (else
     (let ((left-height (height (leftTree tree)))
           (right-height (height (rightTree tree))))
       (+ 1 (max left-height right-height))))))


;; find-min: returns the smallest element in a non-empty BST
;;   input: a non-empty BST
;;   output: the smallest number in the tree
(define (find-min tree)
  (cond
    ((leaf? tree) (key tree)) ; If it's a leaf, return its key
    ((emptyTree? (leftTree tree)) ; If there's no left subtree, the smallest element is at the root
     (key tree))
    (else
     (find-min (leftTree tree)))))


;; find-max: returns the largest element in a non-empty BST
;;   input: a non-empty BST
;;   output: the largest number in the tree
(define (find-max tree)
  (cond
    ((leaf? tree) (key tree)) ; If it's a leaf, return its key
    ((emptyTree? (rightTree tree)) ; If there's no right subtree, the largest element is at the root
     (key tree))
    (else
     (find-max (rightTree tree)))))



;; in-order: returns an ordered list of the elements in a BST
;;   input: a BST
;;   output: a list of all the elements in the BST, in increasing order
(define (in-order tree)
  (cond
    ((emptyTree? tree) '())
    ((leaf? tree) (list (key tree)))
    (else
     (append (in-order (leftTree tree))
             (list (key tree))
             (in-order (rightTree tree))))))


  


;; insertWrong: incorrectly inserts an element into a BST
;;   inputs: an element e to insert and a BST
;;   output: a new BST with e inserted
(define (insertWrong e tree)
  (cond [(emptyTree? tree)
         (make-BST-leaf e)]
        [(= e (key tree)) ; already have the element
         tree]
        [(< e (key tree)) ; insert to the LEFT
         (insertWrong e (leftTree tree))]
        [else             ; insert to the RIGHT
         (insertWrong e (rightTree tree))]
        ))


;; insert: inserts an element into a BST
;;   inputs: an element e to insert and a BST
;;   output: a new BST with e inserted
(define (insert e tree)
  (cond [(emptyTree? tree)
         (make-BST-leaf e)]
        [(= e (key tree)) ; already have the element
         tree]
        [(< e (key tree)) ; insert to the LEFT
         (make-BST (key tree)
                   (insert e (leftTree tree))
                   (rightTree tree))]
        [else             ; insert to the RIGHT
         (make-BST (key tree)
                   (leftTree tree)
                   (insert e (rightTree tree)))]
        ))



;; delete: removes an element from a BST
;;   input: an element e to delete and a BST
;;   outputs: a new BST with e removed (if e appears in the tree)
(define (delete e tree)
  (cond [(emptyTree? tree) tree]
        [(= e (key tree)) ; checks left and right no children
         (cond [(emptyTree? (leftTree tree)) (rightTree tree)]
               [(emptyTree? (rightTree tree)) (leftTree tree)]
               [else
                (make-BST (find-max (leftTree tree)) ; max of the left
                          (delete (find-max (leftTree tree)) (leftTree tree))
                          (rightTree tree))])]
        [(< e (key tree)) ; delete and replace key 
         (make-BST (key tree)
                   (delete e (leftTree tree))
                   (rightTree tree))]
        [else ; left tree delete
         (make-BST (key tree)
                   (leftTree tree)
                   (delete e (rightTree tree)))]))

