#include <iostream>

using namespace std;

int main() {
    int n = 0;
    int q = 0;

    cin >> n >> q;

    int **arr = new int *[n];

    for (int i = 0; i < n; i++) {
        int len = 0;
        cin >> len;
        arr[i] = new int[len];

        for (int j = 0; j < len; j++) {
            int val = 0;
            cin >> val;
            arr[i][j] = val;
        }
    }

    for (int i = 0; i < q; i++) {
        int r = 0;
        int c = 0;

        cin >> r >> c;
        cout << arr[r][c] << endl;
    }

    return 0;
}