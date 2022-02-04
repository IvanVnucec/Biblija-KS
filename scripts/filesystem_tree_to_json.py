"""
Function creates JSON file representing filesystem directory tree.
Call the function as 'python scripts/filesystem_tree_to_json.py <some_folder> > <to_some_file>.json'.
"""

import os
import json
import sys
import re

def tryint(s):
    try:
        return int(s)
    except ValueError:
        return s

def alphanum_key(s):
    return [ tryint(c) for c in re.split('([0-9]+)', s) ]

def path_to_dict(path):
    d = {"name": os.path.basename(path)}
    if os.path.isdir(path):
        d["type"] = "directory"
        d["children"] = [path_to_dict(os.path.join(path, x)) for x in sorted(os.listdir(path), key=alphanum_key)]
    else:
        d["type"] = "file"
    return d


if __name__ == "__main__":
    exit("Error: Input path") if len(sys.argv) != 2 else print(
        json.dumps(path_to_dict(sys.argv[1]))
    )
