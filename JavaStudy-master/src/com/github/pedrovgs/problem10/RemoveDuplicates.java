/*
 * Copyright (C) 2014 Pedro Vicente G贸mez S谩nchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.problem10;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个整形数组, 返回一个无重复元素的新数组。不关心元素顺序. 例:
 *
 * Input: [1,2,3,1] Output: [1,1,12]
 * Input: [1,1,1,1,1] Output: [1]
 *
 * @author Pedro Vicente G贸mez S谩nchez.
 */
public class RemoveDuplicates {

  /**
   * 基于Java Sets实现. To solve this algorithm we have used a Java HashSet and the
   * complexity order of this algorithm in time is O(N) where N is the number of elements in the
   * input array. In space terms, the complexity order of this algorithm is also O(N), because we
   * are using an auxiliary data structure.
   *
   * This implementation is possible in O(N) because the complexity order of HashSets for
   * insertions is O(1).
   */
  public Integer[] removeUsingSet(Integer[] numbers) {
    validateArray(numbers);

    Set<Integer> uniqueElements = new HashSet<Integer>();
    for (int i : numbers) {
      uniqueElements.add(i);
    }
    return uniqueElements.toArray(
    		new Integer[uniqueElements.size()]);
  }

  /**
   * Slow implementation for this algorithm. First of all, sort the array using QuickSort algorithm
   * and then, go through the array and add to a list just those consecutive elements that are
   * different.
   *
   * The complexity order of this algorithm in space terms is O(N) where N is the number of
   * elements in the input array. The complexity order in time terms is equals to the sorting
   * algorithm, O( N log(N)).
   */
  public Integer[] removeUsingSorting(Integer[] numbers) {
    validateArray(numbers);
    if (numbers.length == 1) {
      return numbers;
    }

    Collections.sort(Arrays.asList(numbers));
    List<Integer> result = new LinkedList<Integer>();
    for (int i = 0; i < numbers.length - 1; i++) {
      if (!numbers[i].equals(numbers[i + 1])) {
        result.add(i);
      }
    }
    return result.toArray(new Integer[result.size()]);
  }

  private void validateArray(Integer[] numbers) {
    if (numbers == null) {
      throw new IllegalArgumentException("You can't pass a null array");
    }
  }
}
