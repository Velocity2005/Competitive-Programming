import sys
from io import StringIO

class StringBuilder:
    _file_str = None

    def __init__(self):
        self._file_str = StringIO()

    def append(self, str):
        self._file_str.write(str)
        return self

    def to_string(self):
        return str(self)

    def __str__(self):
        return self._file_str.getvalue()


cases = int(input())

for l in range(cases):
    len = int(sys.stdin.readline())
    ans = StringBuilder()
    if len % 2 == 1:
        ans.append(str(1) + " ")
        for i in range(2, len + 1):
            if i % 2 == 1:
                ans.append(str(i - 1) + " ")
            else:
                ans.append(str(i + 1) + " ")
    else:
        for i in range(1, len + 1):
            if i % 2 == 1:
                ans.append(str(i + 1) + " ")
            else:
                ans.append(str(i - 1) + " ")

    ans.append("\n")
    sys.stdout.write(ans.to_string())
