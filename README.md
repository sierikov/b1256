# b - 1256

A repository to reproduce [1256 bazel issue] and coresponding [StackOverflow question].

![Bazel poster](./public/poster.png)

## Problem description

As described in [StackOverflow question] the problem hides in
dependecies configuration.

### Borrer

For example we need `borrer-core` of version `1.6.3`.
We [define][borrer-define] and [install][borrer-install] it in the `Workspace` file.
This `jar` we then [use][borrer-use] it in our `some-borrer/BUILD` file.

To reproduce run:

```bash
bazel build //some-borrer:lib
```

## How to build

### Build specific target

To build specific target run:

```bash
bazel build //<name>:<mode>
```

where *`name`* can be `some-borrer`, `some-logger` or `some-spark`
and *`mode`* can be `lib`.

### Build all targets

To build all targets at once in this repo use

```bash
bazel build //...
```

## Used technologies

| Technologie   |      Version                                 |
|:--------------|:---------------------------------------------|
| `scala`       | `2.12`                                       |
| `rules_jvm_external`   | `31701ad93dbfe544d597dbe62c9a1fdd76d81d8a9150c2bf1ecf928ecdf97169`                                       |
| `rules_scala` | `5df8033f752be64fbe2cedfd1bdbad56e2033b15`   |
| `bazel`       | `bazel 4.0.0-homebrew`                       |

[borrer-define]: https://github.com/sierikov/b1256/blob/main/WORKSPACE.bazel#L66-L67
[borrer-install]: https://github.com/sierikov/b1256/blob/main/WORKSPACE.bazel#L104-L105
[borrer-use]: https://github.com/sierikov/b1256/blob/main/some-borrer/BUILD.bazel#L14-L15
[1256 bazel issue]: https://github.com/bazelbuild/rules_scala/issues/1256
[StackOverflow question]: https://stackoverflow.com/questions/66640581/bazel-scala-failed-worker-process-did-not-return-a-workresponse
