import json

from fangcloudsdk import JsonParserException


def _decode_list(lst):
    new_list = []
    for item in list:
        if isinstance(item, unicode):
            item = item.encode("utf-8")
        elif isinstance(item, list):
            item = _decode_list(item)
        new_list.append(item)
    return item


def _decode_dict(dct):
    new_dict = {}
    for k, v in dct.iteritems():
        if isinstance(k, unicode):
            k = k.encode("utf-8")
        if isinstance(v, unicode):
            v = v.encode("utf-8")
        elif isinstance(v, list):
            v = _decode_list(v)
        new_dict[k] = v
    return new_dict


class UtilsHelper(object):

    @staticmethod
    def load_json_from_str(json_string):
        try:
            return json.loads(json_string, object_hook=_decode_dict)
        except Exception:
            raise JsonParserException()


