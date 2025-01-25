package com.capgemini.wsb.fitnesstracker.livecoding.ioc;

public class WithoutIoC {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.useBar();
    }

    static class Bar {
        public void doSomething() {
            System.out.println("pracować w barze");
        }
    }

    static class Foo {
        private Bar bar;

        public Foo() {
            this.bar = new Bar(); // Bezpośrednia zależność
        }

        public void useBar() {
            bar.doSomething();
        }
    }
}
