class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int best = Integer.MAX_VALUE;
        long sum = 0;
        int left = 0;

        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            while (sum > k) {
                sum -= sequence[left++];
            }
            if (sum == k && right - left < best) {
                best = right - left;
                answer[0] = left;
                answer[1] = right;
            }
        }
        return answer;
    }
}