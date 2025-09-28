# Assignment 1 – Divide and Conquer Algorithms
## Project Overview

This project implements and benchmarks classic divide-and-conquer algorithms in Java:

- MergeSort – Top-down merge sort with insertion sort cutoff.
- QuickSort – Optimized quicksort with randomized pivot and smaller-partition-first recursion.
- Deterministic Select – Median-of-Medians selection algorithm to find the k-th smallest element in O(n).
- Closest Pair of Points – Efficient 2D closest-pair algorithm using divide-and-conquer.

Metrics collected:
- Recursion depth
- Number of comparisons
- Execution time

---
## Architecture Notes
- Metrics class tracks recursion depth and comparisons.
- MergeSort uses a reusable buffer and small-n cutoff for insertion sort.
- QuickSort performs tail recursion optimization by iterating over the larger partition.
- Deterministic Select recurses only into the needed side, ensuring O(n) complexity.
- Closest Pair splits points by x-coordinate and uses a strip scan by y-coordinate, checking only nearby points.
---
## Recurrence Analysis

1. MergeSort
- Recurrence: T(n) = 2T(n/2) + Θ(n)
- Master Theorem Case 2 → Θ(n log n)
- Measurements: depth ~ log n; comparisons close to theoretical n log n.

2. QuickSort
- Average case: T(n) = T(n/2) + T(n/2) + Θ(n) ≈ Θ(n log n)
- Worst-case avoided by random pivot and smaller-partition-first recursion.
- Metrics show recursion depth bounded by ~2*log2(n).

3. Deterministic Select
- Recurrence: T(n) = T(n/5) + T(7n/10) + Θ(n)
- Akra–Bazzi intuition → Θ(n)
- Only recurses into one partition; metrics confirm linear number of comparisons.

4. Closest Pair
- Recurrence: T(n) = 2T(n/2) + Θ(n) → Θ(n log n)
- Strip check requires constant (≈7–8) neighbor comparisons.
- Observed times align with theory for n ≤ 1000 points.

<img width="509" height="155" alt="Снимок экрана 2025-09-28 182656" src="https://github.com/user-attachments/assets/74b0708a-1cab-44c8-8fa6-0cd404c54d7a" />
<img width="603" height="359" alt="image" src="https://github.com/user-attachments/assets/76889a70-dd35-43fa-8b2a-7f28af22678a" />

---
## Benchmarks 
MergeSort: 4.5 ms, depth=10, comparisons=8345

QuickSort: 3.1 ms, depth=11, comparisons=8412

DeterministicSelect (k=500): 5277

Closest pair distance: 0.128

## Notes:
- QuickSort is slightly faster for random arrays due to in-place operations.
- MergeSort is stable and consistent.
- DeterministicSelect efficiently finds the median.
- Closest Pair is efficient for 2D points.
- Minor differences due to cache effects and garbage collection.

## Testing
- Sorting: Random and small arrays; recursion depth tracked.
- Select: Verified against over 100 trials.Arrays.sort(a)[k]
- Closest Pair: Verified against O(n²) solution for small n ≤ 2000.
- All algorithms pass JUnit 5 tests.
---

## Summary
- Theory vs Measurements: Depth and comparisons match expectations.
- MergeSort and QuickSort align with Θ(n log n); DeterministicSelect linear as expected.
- Closest Pair results match theoretical O(n log n) with strip optimization.
- Minor deviations explained by cache, memory allocation, and Java GC.

---
