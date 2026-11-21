
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] newParent = new int[n];
        int[] last = new int[26];
        int[] prevSame = new int[n];

        Arrays.fill(last, -1);

        // DFS on original tree
        Stack<Integer> st = new Stack<>();
        st.push(0);

        while (!st.isEmpty()) {

            int event = st.pop();

            // Exit event: restore previous ancestor
            if (event < 0) {
                int u = ~event;
                last[s.charAt(u) - 'a'] = prevSame[u];
                continue;
            }

            int u = event;
            int ch = s.charAt(u) - 'a';

            prevSame[u] = last[ch];

            if (u == 0) {
                newParent[u] = -1;
            } else if (last[ch] != -1) {
                newParent[u] = last[ch];
            } else {
                newParent[u] = parent[u];
            }

            last[ch] = u;

            // Push exit event
            st.push(~u);

            // Push children
            for (int v : children[u]) {
                st.push(v);
            }
        }

        // Build modified tree
        List<Integer>[] updated = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            updated[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            updated[newParent[i]].add(i);
        }

        // Get traversal order
        List<Integer> order = new ArrayList<>();
        st.push(0);

        while (!st.isEmpty()) {
            int u = st.pop();
            order.add(u);

            for (int v : updated[u]) {
                st.push(v);
            }
        }

        // Calculate subtree sizes
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = order.size() - 1; i >= 0; i--) {

            int u = order.get(i);

            if (newParent[u] != -1) {
                ans[newParent[u]] += ans[u];
            }
        }

        return ans;
    }
}
