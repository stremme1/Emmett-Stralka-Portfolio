#lang racket

(require rackunit)
(require "BST.rkt")
(require "BSTfunctions.rkt")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part A: Create 4 additional trees
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define emptyBST (make-empty-BST))

(define tree1 (make-BST 10 emptyBST emptyBST))

(define tree2 (make-BST 10 (make-BST 5 emptyBST emptyBST) emptyBST))

(define tree3 (make-BST 10 emptyBST (make-BST 15 emptyBST emptyBST)))

(define tree4 (make-BST 10 (make-BST 5 emptyBST emptyBST) (make-BST 15 emptyBST emptyBST)))

(define bigTree
  (make-BST 50
            (make-BST 30
                      (make-BST 20 emptyBST emptyBST)
                      (make-BST 40 emptyBST emptyBST))
            (make-BST 70
                      (make-BST 60 emptyBST emptyBST)
                      (make-BST 80 emptyBST emptyBST))))

(define bigBST
  (make-BST 42
            (make-BST 20
                      (make-BST 7 (make-BST-leaf 1) (make-BST-leaf 8))
                      (make-BST 31 emptyBST (make-BST-leaf 41)))
            (make-BST 100
                      (make-BST-leaf 60)
                      emptyBST)))


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
(check-equal? (height emptyBST) -1)
(check-equal? (height bigTree) 3)

(check-equal? (height tree1) 0)
(check-equal? (height tree2) 1)
(check-equal? (height tree3) 1)
(check-equal? (height tree4) 1)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part C: Test find-min
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

; provided tests
(check-equal? (find-min bigBST) 1)

(check-equal? (find-min bigTree) 20)
(check-equal? (find-min tree1) 10)
(check-equal? (find-min tree2) 5)
(check-equal? (find-min tree3) 10)
(check-equal? (find-min tree4) 5)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part D: Test in-order
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 

; provided tests
(check-equal? (in-order emptyBST) '())
(check-equal? (in-order bigBST) '(1 7 8 20 31 41 42 60 100))

(check-equal? (in-order bigTree) '(20 30 40 50 60 70 80))
(check-equal? (in-order tree1) '(10))
(check-equal? (in-order tree2) '(5 10))
(check-equal? (in-order tree3) '(10 15))
(check-equal? (in-order tree4) '(5 10 15))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Part F: Test delete
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

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

(check-equal? (delete 20 bigBST) bigBST_without20)

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

(check-equal? (delete 42 bigBST) bigBST_without42)

; student tests
;; Remove 99 from a tree that does not contain 99
(define bigBST_without99
  (make-BST 60
            (make-BST 20
                      (make-BST 7
                                (make-BST-leaf 1)
                                (make-BST-leaf 8))
                      (make-BST 31
                                (make-empty-BST)
                                (make-BST-leaf 41)))
            (make-BST-leaf 100)))

(check-equal? (delete 99 bigBST) bigBST_without99)

;; Remove 5 from a tree where 5 is the only node
(define bst_without5 (make-empty-BST))
(check-equal? (delete 5 (make-BST-leaf 5)) bst_without5)

;; Remove 8 from a tree where 8 has no children & was in a left subtree
(define bst_without8 (make-BST 10 (make-BST-leaf 5) (make-empty-BST)))
(check-equal? (delete 8 (make-BST 10 (make-BST-leaf 5) (make-BST-leaf 8))) bst_without8)

;; Remove 41 from a tree where 41 has no children & was in a right subtree
(define bst_without41 (make-BST 40 (make-BST-leaf 30) (make-empty-BST)))
(check-equal? (delete 41 (make-BST 40 (make-BST-leaf 30) (make-BST-leaf 41))) bst_without41)

;; Remove 60 from a tree where 60 was at the root & has only a right child
(define bst_without60_right_child (make-BST 70 (make-empty-BST) (make-BST-leaf 80)))
(check-equal? (delete 60 (make-BST 60 (make-empty-BST) (make-BST-leaf 80))) bst_without60_right_child)

;; Remove 60 from a tree where 60 was at the root & has only a left child
(define bst_without60_left_child (make-BST 50 (make-BST-leaf 40) (make-empty-BST)))
(check-equal? (delete 60 (make-BST 60 (make-BST-leaf 50) (make-empty-BST))) bst_without60_left_child)

;; Remove 60 from a tree where 60 was at the root & has two children
(define bst_without60_two_children (make-BST 70 (make-BST-leaf 50) (make-BST-leaf 80)))
(check-equal? (delete 60 (make-BST 60 (make-BST-leaf 50) (make-BST-leaf 80))) bst_without60_two_children)

