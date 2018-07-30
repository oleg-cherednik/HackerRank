#include <iostream>
#include <sstream>
#include <string>
#include <exception>
#include <vector>
#include <cmath>
#include <map>

using namespace std;

struct Node {
    Node *next;
    Node *prev;
    int value;
    int key;

    Node(Node *p, Node *n, int k, int val) : prev(p), next(n), key(k), value(val) {};

    Node(int k, int val) : prev(NULL), next(NULL), key(k), value(val) {}
};

class Cache {
protected:
    map<int, Node *> mp;
    int cp;
    Node *tail;
    Node *head;

    virtual void set(int, int) = 0;

    virtual int get(int) = 0;
};

class LRUCache : public Cache {
public:
    LRUCache(int c) {
        cp = c;
    }

    void set(int k, int v) {
        if (cp <= 0)return;
        Node *N;
        if (mp.empty()) {
            N = new Node(k, v);
            tail = head = N;
            mp[k] = N;
        } else if (mp.find(k) != mp.end()) {
            auto p = mp[k];
            p->value = v;
            if (tail == p) {
                tail = tail->prev;
            }
            if (head != p) {
                p->prev->next = p->next;
                p->next = head;
                head->prev = p;
                head = p;
            }
            if (tail == p) {
                tail = tail->prev;
            }
        } else if (mp.size() < cp) {
            N = new Node(NULL, head, k, v);
            head->prev = N;
            head = N;
            mp[k] = N;
        } else {
            auto t = tail;
            tail = tail->prev;
            mp.erase(t->key);
            N = new Node(NULL, head, k, v);
            head = N;
            mp[k] = N;
        }
    }

    int get(int k) {
        auto p = mp.find(k);
        if (p != mp.end()) {
            return p->second->value;
        }
        return -1;
    }
};

int main() {
    int n, capacity;
    cin >> n >> capacity;

    LRUCache l(capacity);

    for (int i = 0; i < n; i++) {
        string command;
        cin >> command;

        if (command == "get") {
            int key;
            cin >> key;
            cout << l.get(key) << endl;
        } else if (command == "set") {
            int key, value;
            cin >> key >> value;
            l.set(key, value);
        }
    }

    return 0;
}