from setuptools import setup, find_packages

CLASSIFIERS = [
    'Development Status :: 5 - Production/Stable',
    'Intended Audience :: Developers',
    'License :: OSI Approved :: Apache Software License',
    'Programming Language :: Python',
    'Programming Language :: Python :: 2.7',
    'Programming Language :: Python :: 3.5',
    'Programming Language :: Python :: Implementation :: CPython',
    'Programming Language :: Python :: Implementation :: PyPy',
    'Operating System :: OS Independent',
    'Operating System :: POSIX',
    'Operating System :: Microsoft :: Windows',
    'Operating System :: MacOS :: MacOS X',
    'Operating System :: LinuxOS :: Linux',
    'Operating System :: UnixOS :: Unix',
    'Topic :: Software Development :: Libraries :: Python Modules',
]
setup(
    name='fangcloud_sdk',
    version='0.0.3',
    keywords=('fangcloud', 'sdk', 'open', 'platform'),
    description='This is fangcloud open platform python sdk',
    url='http://www.fangcloud.com',
    author='FangCloud',
    author_email='1743159479@qq.com',
    packages=find_packages(),
    include_package_data=True,
    platforms='any',
    install_requires=["requests"],
    license='Apache Software License, Version 2.0,http://www.apache.org/licenses/LICENSE-2.0',
)
