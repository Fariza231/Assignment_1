# Assignment 1 
## Project Overview

This project implements and benchmarks classic divide-and-conquer algorithms in Java:

- MergeSort – Top-down merge sort with insertion sort cutoff.
- QuickSort – Optimized quicksort with randomized pivot and smaller-partition-first recursion.
- Deterministic Select – Median-of-Medians selection algorithm to find the k-th smallest element in O(n).
- Closest Pair of Points – Efficient 2D closest-pair algorithm using divide-and-conquer.

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
## Conclusion
The conducted experiments demonstrate that the implemented algorithms closely follow their theoretical performance.  
MergeSort and QuickSort showed expected Θ(n log n) behavior, Deterministic Select confirmed linear performance, and Closest Pair achieved efficiency beyond the naive O(n²) approach. Minor runtime variations are attributed to system-level factors, but overall the results validate the correctness and efficiency of the divide-and-conquer strategies.

---
