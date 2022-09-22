class Solution:
    def reverseWords(self, s: str) -> str:
        h = s.split(" ")
        for i in range(len(h)):
            h[i] = h[i][::-1]
        return ' '.join(a for a in h)