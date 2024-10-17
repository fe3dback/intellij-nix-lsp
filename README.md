# Nix LSP Plugin

<!-- Plugin description -->
This is very simple plugin, that provide extended NIX language support
from LSP plugin:
- https://github.com/nix-community/nixd

For better syntax highlight, it's strongly recommended to also install:
- https://plugins.jetbrains.com/plugin/8607-nixidea

### How to install:

Add `nixd` to system packages.
Plugin assumes that `nixd` is installed and available in your host.

```nix
environment.systemPackages = with pkgs; [
    nixd
];
```

Then download and install this plugin from jetbrains marketplace.

<!-- Plugin description end -->