from typing import List
from collections import defaultdict

class Solution:
    def checkIfPrerequisite(self, numCourses: int, prerequisites: List[List[int]], queries: List[List[int]]) -> List[bool]:
        direct_pre = defaultdict(list)  
        all_pre = {}  
        result = []

        # Build the adjacency list
        for pre, course in prerequisites:
            direct_pre[course].append(pre)

        # Function to compute all prerequisites for a course
        def dfs(course):
            if course in all_pre:
                return all_pre[course]

            course_pres = set(direct_pre[course])

            for pre in direct_pre[course]:
                course_pres |= dfs(pre)

            all_pre[course] = course_pres
            return course_pres

        # Precompute all prerequisites for all courses
        for course in range(numCourses):
            dfs(course)

        # Answer each query
        for pre, course in queries:
            result.append(pre in all_pre[course])

        return result