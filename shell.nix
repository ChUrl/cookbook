{ pkgs ? import <nixpkgs> {} }:

with pkgs;

mkShell {
  buildInputs = [
    jdk11
    jetbrains.idea-ultimate
    gradle
    docker-compose
    dbeaver
    nodejs
    nodePackages.npm
  ];
}
