#lang racket

(require rackunit)
(require "BST.rkt")
(require "BSTfunctions.rkt")


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part A : Create 4 additional trees
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; provided: an empty binary search tree
(define emptyBST (make-empty-BST))

;; TODO: make simpler trees

;; student: a binary search tree with one node

;; student: a binary search tree with a left child

;; student: a binary search tree with a right child

;; student: a binary search tree with two children

;; provided: a big binary search tree
(define bigBST 
  (make-BST 42
            (make-BST 20
                      (make-BST 7
                                (make-BST-leaf 1)
                                (make-BST-leaf 8))
                      (make-BST 31
                                (make-empty-BST)
                                (make-BST-leaf 41)))
            (make-BST 100 
                      (make-BST-leaf 60)
                      (make-empty-BST))))

; provided tests
(check-equal? (key tree-wOneNode) 7)
(check-equal? (leftTree tree-wOneNode) emptyBST)
(check-equal? (rightTree tree-wOneNode) emptyBST)

(check-equal? (key tree-wLeftChild) 7)
(check-equal? (leftTree tree-wLeftChild) (make-BST-leaf 1))
(check-equal? (rightTree tree-wLeftChild) emptyBST)
(check-equal? (key (leftTree tree-wLeftChild)) 1)

(check-equal? (key tree-wRightChild) 7)
(check-equal? (leftTree tree-wRightChild) emptyBST)
(check-equal? (rightTree tree-wRightChild) (make-BST-leaf 8))
(check-equal? (key (rightTree tree-wRightChild)) 8)

(check-equal? (key tree-wTwoChildren) 7)
(check-equal? (leftTree tree-wTwoChildren) (make-BST-leaf 1))
(check-equal? (rightTree tree-wTwoChildren) (make-BST-leaf 8))
(check-equal? (key (leftTree tree-wTwoChildren)) 1)
(check-equal? (key (rightTree tree-wTwoChildren)) 8)

(check-true  (emptyTree? emptyBST))
(check-false (emptyTree? tree-wOneNode))
(check-false (emptyTree? tree-wLeftChild))
(check-false (emptyTree? (leftTree tree-wLeftChild)))
(check-true  (emptyTree? (rightTree tree-wLeftChild)))
(check-false (emptyTree? tree-wRightChild))
(check-true  (emptyTree? (leftTree tree-wRightChild)))
(check-false (emptyTree? (rightTree tree-wRightChild)))
(check-false (emptyTree? tree-wTwoChildren))
(check-false (emptyTree? (leftTree tree-wTwoChildren)))
(check-false (emptyTree? (rightTree tree-wTwoChildren)))

(check-true  (leaf? tree-wOneNode))
(check-false (leaf? tree-wLeftChild))
(check-true  (leaf? (leftTree tree-wLeftChild)))
(check-false (leaf? tree-wRightChild))
(check-true  (leaf? (rightTree tree-wRightChild)))
(check-false (leaf? tree-wTwoChildren))
(check-true  (leaf? (leftTree tree-wTwoChildren)))
(check-true  (leaf? (rightTree tree-wTwoChildren)))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part B: Test height
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; provided tests
;(check-equal? (height emptyBST) -1)
;(check-equal? (height bigBST) 3)

; student tests
;; TODO: add tests for height


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part C: Test find-min
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; provided tests
;(check-equal? (find-min bigBST) 1)

; student tests
;; TODO: add tests for find-min


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part D: Test in-order
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 

; provided tests
;(check-equal? (in-order emptyBST) '())
;(check-equal? (in-order bigBST) '(1 7 8 20 31 41 42 60 100))

; student tests
;; TODO: add tests for in-order


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part F: Test delete
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; provided tests
(define bigBST_without20
  (make-BST 42
            (make-BST 31
                      (make-BST 7
                                (make-BST-leaf 1)
                                (make-BST-leaf 8))
                      (make-BST-leaf 41))
            (make-BST 100
                      (make-BST-leaf 60)
                      (make-empty-BST))))

;(check-equal? (delete 20 bigBST) bigBST_without20)


(define bigBST_without42
  (make-BST 60
            (make-BST 20
                      (make-BST 7
                                (make-BST-leaf 1)
                                (make-BST-leaf 8))
                      (make-BST 31
                                (make-empty-BST)
                                (make-BST-leaf 41)))
            (make-BST-leaf 100)))

;(check-equal? (delete 42 bigBST) bigBST_without42)

; student tests
;; TODO: add tests for delete

; Remove X from a tree that does not contain X

; Remove X from a tree where X is the only node

; Remove X from a tree where X has no children & was in a left subtree

; Remove X from a tree where X has no children & was in a right subtree

; Remove X from a tree where X was at the root & has only a right child

; Remove X from a tree where X was at the root & has only a left child

; Remove X from a tree where X was at the root & has two children
