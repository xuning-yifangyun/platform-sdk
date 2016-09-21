dict_str = {
    "num1": 111,
    "num2": 222,
    "stu": {
        "stu1": "xuning_1",
        "stu2": "xuning_2"
    }
}
import json

json_str = json.dumps(dict_str)
print(json_str)
s=json.loads(json_str)
s1=s['stu']