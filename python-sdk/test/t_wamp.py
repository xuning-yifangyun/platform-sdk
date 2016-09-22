# def log(func):
#     def ware(*args, **kwargs):
#         return func(*args, **kwargs)
#     return ware
#
# @log
# def f(var1):
#     print(var1)
#
# f(4)

# coding: utf-8

from __future__ import unicode_literals, absolute_import
from functools import update_wrapper, wraps


def api_call(method):

    return APICallWrapper(method)


class APICallWrapper(object):

    def __init__(self, func_that_makes_an_api_call):
        super(APICallWrapper, self).__init__()
        self._func_that_makes_an_api_call = func_that_makes_an_api_call
        update_wrapper(self, func_that_makes_an_api_call)

    def __get__(self, _instance, owner):
        @wraps(self._func_that_makes_an_api_call)
        def call(*args, **kwargs):
            instance = _instance
            if instance is None:
                # If this is being called as an unbound method, the instance is the first arg.
                if owner is not None and len(args) > 0 and isinstance(args[0], owner):
                    instance = args[0]
                    args = args[1:]
                else:
                    raise TypeError
            extra_network_parameters = kwargs.pop('extra_network_parameters', None)
            if extra_network_parameters:
                # If extra_network_parameters is specified, then clone the instance, and specify the parameters
                # as the defaults to be used.
                # pylint: disable=protected-access
                instance = instance.clone(instance._session.with_default_network_request_kwargs(extra_network_parameters))
                # pylint: enable=protected-access
            response = self._func_that_makes_an_api_call(instance, *args, **kwargs)
            return response
        return call