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
    explicit LRUCache(int cp) {
        this->cp = cp;
    }

    void set(int key, int value) override {
        if (cp <= 0)
            return;

        if (mp.empty())
            mp[key] = tail = head = new Node(key, value);
        else if (mp.find(key) != mp.end()) {
            mp[key]->value = value;

            if (tail == mp[key])
                tail = tail->prev;

            if (head != mp[key]) {
                mp[key]->prev->next = mp[key]->next;
                mp[key]->next = head;
                head->prev = mp[key];
                head = mp[key];
            }

            if (tail == mp[key])
                tail = tail->prev;
        } else if (mp.size() < cp) {
            head->prev = new Node(nullptr, head, key, value);
            head = head->prev;
            mp[key] = head;
        } else {
            auto node = tail;
            tail = tail->prev;
            mp.erase(node->key);
            mp[key] = head = new Node(nullptr, head, key, value);
        }
    }

    int get(int k) override {
        auto it = mp.find(k);
        return it != mp.end() ? it->second->value : -1;
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