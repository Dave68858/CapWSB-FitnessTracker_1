package com.capgemini.wsb.fitnesstracker.livecoding.ioc;

public class IoC {

    public static void main(String[] args) {
        // Utworzona instancja
        Bar bar = new Bar();

        // Foo skonstruowane z bar
        Foo foo = new Foo(bar);
        foo.useBar();
    }

    static class Bar {
        public void doSomething() {
            System.out.println("Pracować w barze");
        }
    }

    static class Foo {
        private Bar bar;

        // Zależności wynikające z zewnątrz
        public Foo(Bar bar) {
            this.bar = bar;
        }

        public void useBar() {
            bar.doSomething();
        }
    }
}
